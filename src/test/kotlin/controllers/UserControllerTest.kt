package controllers

//import models.Users
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//
//import org.junit.jupiter.api.Assertions.*
//import org.mockito.Mock
//import services.UsersService
//
//internal class UserControllerTest {
//    @Mock
//    private lateinit var userController: UserController
//    private lateinit var user: Users
//
//    @BeforeEach
//    fun init() {
//        userController= UserController()
//        user = Users(id = 1, name = "test", email = "test@testers.com", number = 12345)
//        userController.addUser(user)
//    }
//
//    @Test
//    fun addUser() {
//        user = Users(id = 1, name = "dev", email = "dev@gmail.com", number = 9876543210)
//        val response = userController.addUser(user)
//        assertEquals(response.toString(),"User successfully created")
//    }
//
//
//}