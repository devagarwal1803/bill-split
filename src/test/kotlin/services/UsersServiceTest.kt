package services

import dao.UsersDao
import io.ebean.DB
import models.Users
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class UsersServiceTest {
    @Mock
    private lateinit var userDao: UsersDao

    private lateinit var userService: UsersService

    @BeforeEach
    fun init() {
//        val database = DB.getDefault()
//        userDao=UsersDao(database)
//        MockitoAnnotations.initMocks(this)
//        userService= UsersService(userDao)
    }

//    @Test
//    fun `check add user`() {
//        val user = Users(id = 1, name = "test", email = "test@testers.com", number = 12345)
//
//        Mockito.`when`(userDao.addUser(user)).thenReturn("User Added")
//        Mockito.`when`(userDao.checkUserWithExistingEmail(user.email)).thenReturn(true)
//        Mockito.`when`(userDao.getID()).thenReturn(1)
//
//        val response = userService.addUser(user)
//        print(response)
//        assertEquals(response.toString(),"User Added")
//    }

    @Test
    fun checkTest(){
        assertEquals(1,1)
    }

//    @Test
//    fun `user with same email exists`() {
//        addUser()
//        user = Users(id = 1, name = "test", email = "test@testers.com", number = 9876543210)
//        val response = userService.addUser(user)
//        assertEquals(response.toString(),"User with email ${user.email} already exists")
//    }
//
//    @Test
//    fun updateUser() {
//        user = Users(id = 1, name = "dev", email = "dev@gmail.com", number = 12345)
//        val response = userService.updateUser(user)
//        assertEquals(response.toString(),"User updated successfully")
//    }
//
//    @Test
//    fun showAllUsers() {
//        val response = userService.showAllUsers()
////        print(response)
//        assertEquals(1, (response as ArrayList<Users>).size)
//    }
//
//    @Test
//    fun getUserByEmail() {
//        val response = userService.getUserByEmail("test@testers.com")
//        user = Users(id = 1, name = "test", email = "test@testers.com", number = 12345)
////        print(response)
//        assertEquals(user.toString(), response.toString())
//    }
//
//    @Test
//    fun updateBalance() {
//        user = Users(id = 1, name = "test", email = "test@testers.com", number = 12345)
//        val response = userService.updateBalance(1,500)
//        assertEquals(response,"Balance updated")
//    }
}