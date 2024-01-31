package com.example.idlewonders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idlewonders.R
import com.example.idlewonders.data.WorkAmount
import com.example.idlewonders.data.models.Employee

@Composable
fun EmployeeListTile(employee: Employee, modifier: Modifier = Modifier) {

    val statText = if (employee.baseWorkPerSecond > WorkAmount(0)) "+${employee.baseWorkPerSecond} work/second" else "+${employee.tapBonus} work/tap"

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xffffd65a)),
        modifier = modifier.height(72.dp)
    ) {
        Row(modifier = modifier.padding(4.dp)) {
            Box(
                modifier = modifier.weight(0.5F)
            ) {
                Image(
                    painter = painterResource(id = employee.imageResId),
                    contentDescription = employee.empDescription,
                    modifier = modifier
                        .size(68.dp)
                )

            }
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .fillMaxHeight()
                    .weight(1F)
            ) {
                Text(text = employee.name, fontSize = 20.sp)
                Text(text = employee.empDescription, fontSize = 10.sp)
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxHeight()
                    .padding(end = 18.dp)
                    .weight(1F)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${employee.baseCost}", fontSize = 16.sp)
                    Image(
                        painter = painterResource(id = R.drawable.coin_symbol),
                        contentDescription = "coin symbol",
                        modifier = modifier
                            .padding(start = 4.dp)
                            .size(24.dp)
                    )
                }
                Text(text = statText, fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewEmployeeListTile() {
    EmployeeListTile(Employee.employeeList[0])
}