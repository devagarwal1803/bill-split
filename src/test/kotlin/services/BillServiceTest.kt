package services

import requests.Bill
import models.Users
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import java.util.ArrayList

internal class BillServiceTest {
    @Mock
    private lateinit var bills: Bill

    private lateinit var billService: BillService
    private lateinit var usersService: UsersService

    @BeforeEach
    fun setUp() {
        usersService = UsersService()
        billService = BillService()
        var user1=Users(id = 1, name = "test", email = "test@testers.com", number = 123456789)
        var user2=Users(id = 2, name = "test2", email = "test2@testers.com", number = 987654321)
        var bill = Bill(id = 1, amt=100, ownedBy = listOf<Int>(1), ownedTo = listOf<Int>(2))
        usersService.addUser(user1)
        usersService.addUser(user2)
        billService.addB(bill,usersService)
    }

    @Test
    fun addB() {
        var list1 = listOf<Int>(1)
        var list2 = listOf<Int>(2)
        var bill = Bill(id = 2, amt=500, ownedBy = list1, ownedTo = list2)
        var response = billService.addB(bill, usersService)
        print(response)
        assertEquals(response,"Bill added successfully")
    }

    @Test
    fun showAllBills() {
        var response = billService.showAllBills()
        println(response)
        assertEquals(1, (response as ArrayList<Users>).size)
    }
}