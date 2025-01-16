package com.example.folkedex.domain

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.folkedex.data.model.Actor

@Composable
fun ActorItem(actor: Actor) {
    val partyInfo = extractAllTagsFromXml(actor.biografi, "party")
    val parliamentPosition = extractAllTagsFromXml(actor.biografi, "parliamentaryPositionOfTrust")
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "${actor.fornavn ?: ""} ${actor.efternavn ?: ""}".trim(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))


            if (!actor.biografi.isNullOrBlank()) {
                Text(
                    text = "Party: ${partyInfo.get(0)}",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(4.dp))
            if (!actor.biografi.isNullOrBlank()) {
                Text(
                    text = "Position: $parliamentPosition",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(8.dp))
            }





        }
    }
}