package com.kotlin.mavendemo.entity

import jakarta.persistence.*
import com.kotlin.mavendemo.entity.Role

@Entity
data class User(
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long = 0,
    val name: String,
    val email: String,
    val password: String,
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: List<Role> = listOf()
    
    // val roles: List<Role> = listOf()
){
    
    override fun toString(): String{
        return "userId : "+this.userId+"\nname : "+this.name+"\nemail : "+this.email+"roles : "+roles.toString()
    }
}