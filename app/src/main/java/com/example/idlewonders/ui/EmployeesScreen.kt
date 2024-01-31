package com.example.idlewonders.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.idlewonders.R
import com.example.idlewonders.data.models.Employee
import com.example.idlewonders.ui.components.BackButton
import com.example.idlewonders.ui.components.EmployeeListTile

@Composable
fun EmployeesScreen(
    modifier: Modifier = Modifier,
    backNav: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.tile_back),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Row {
                BackButton(backNav = backNav)
            }

            Spacer(modifier = modifier.weight(1F))
            LazyColumn(
                contentPadding = PaddingValues(4.dp),
                modifier = modifier
                    .height(232.dp),
                userScrollEnabled = true
            ) {
                items(Employee.employeeList) { employee ->
                    EmployeeListTile(employee = employee)
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewEmployeesScreen() {
    EmployeesScreen(backNav = {})
}