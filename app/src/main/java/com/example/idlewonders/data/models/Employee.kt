package com.example.idlewonders.data.models

import android.media.Image
import com.example.idlewonders.data.EmployeeId
import com.example.idlewonders.data.Money
import com.example.idlewonders.data.WorkAmount

class Employee(
    override var baseCost: Money,
    val name: String,
    val empDescription: String,
//    val image: Image,
    val guid: EmployeeId,
    val baseWorkPerSecond: WorkAmount,
    val tapBonus: WorkAmount
) : Purchasable {

    companion object {
        val employeeList = listOf(
            Employee(
                baseCost = Money("10.00"),
                name = "Worker",
                empDescription = "Performs your commands to the letter.",
                //imageName = "worker_back",
                guid = "buyable1",
                baseWorkPerSecond = WorkAmount(0),
                tapBonus = WorkAmount("1.00")
            ),

            Employee(
                baseCost = Money("50.00"),
                name = "Hauler",
                empDescription = "Lifts heavy things and then puts them down.",
                //imageName= "hauler_back",
                guid = "buyable2",
                baseWorkPerSecond = WorkAmount("1.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("500.00"),
                name = "Hammerer",
                empDescription = "Helps you turn rocks into smaller rocks.",
                //imageName= "hammerer_back",
                guid = "buyable3",
                baseWorkPerSecond = WorkAmount(0),
                tapBonus = WorkAmount("5.00")
            ),

            Employee(
                baseCost = Money("1000.00"),
                name = "Stone Mason",
                empDescription = "Bangs rocks until they make shapes.",
                //imageName= "stonemason_back",
                guid = "buyable4",
                baseWorkPerSecond = WorkAmount("5.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("100000.00"),
                name = "Artificer",
                empDescription = "Crafts all sorts of tools and parts.",
                //imageName= "artificer_back",
                guid = "buyable5",
                baseWorkPerSecond = WorkAmount("10.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("2500000.00"),
                name = "Quarrier",
                empDescription = "A superstar at breaking rocks into blocks and vice versa.",
                //imageName= "quarrier_back",
                guid = "buyable6",
                baseWorkPerSecond = WorkAmount(0),
                tapBonus = WorkAmount("25.00")
            ),

            Employee(
                baseCost = Money("50000000.00"),
                name = "Brick Layer",
                empDescription = "One hand on the brick, one hand on the trowel.",
                //imageName= "brick_layer_back",
                guid = "buyable7",
                baseWorkPerSecond = WorkAmount("25.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("140000000.00"),
                name = "Mortar Mixer",
                empDescription = "Makes sure there's plenty of mortar for bricks.",
                //imageName= "mortar_mixer_back",
                guid = "buyable11",
                baseWorkPerSecond = WorkAmount("50.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("175000000.00"),
                name = "Crane Operator",
                empDescription = "Man, ancient cranes are hard...",
                //imageName= "crane_operator_back",
                guid = "buyable8",
                baseWorkPerSecond = WorkAmount(0),
                tapBonus = WorkAmount("50.00")
            ),

            Employee(
                baseCost = Money("400000000.00"),
                name = "Master Crafter",
                empDescription = "Specialized crafts for world wonders.",
                //imageName= "master_crafter_back",
                guid = "buyable9",
                baseWorkPerSecond = WorkAmount("100.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("500000000.00"),
                name = "Expert Carver",
                empDescription = "Can carve anything into anything else.",
                //imageName= "expert_carver_back",
                guid = "buyable15",
                baseWorkPerSecond = WorkAmount(0),
                tapBonus = WorkAmount("100.00")
            ),

            Employee(
                baseCost = Money("1000000000.00"),
                name = "Surveyer",
                empDescription = "An expert in lengths, heights, and widths.",
                //imageName= "surveyer_back",
                guid = "buyable10",
                baseWorkPerSecond = WorkAmount("250.00"),
                tapBonus = WorkAmount(0)
            ),

            Employee(
                baseCost = Money("9000000000.00"),
                name = "Contractor",
                empDescription = "Willing to do any work as long as the money's right.",
                //imageName= "contractor_back",
                guid = "buyable14",
                baseWorkPerSecond = WorkAmount("500.00"),
                tapBonus = WorkAmount(0)
            )
        )
    }
}

