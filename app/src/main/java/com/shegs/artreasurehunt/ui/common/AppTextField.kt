@file:OptIn(ExperimentalMaterial3Api::class)

package com.shegs.artreasurehunt.ui.common


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shegs.artreasurehunt.ui.theme.Typography
import com.shegs.artreasurehunt.ui.theme.grey2
import com.shegs.artreasurehunt.ui.theme.grey3
import com.shegs.artreasurehunt.ui.theme.md_theme_light_onPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(
    leadingIcon: Int? = null,
    modifier: Modifier,
    maxLines: Int = 1,
    containerColor: Color? = grey2,
    value: String,
    placeholder: String? = "",
    placeholderColor: Color? = grey3,
    placeholderComposable: @Composable (() -> Unit)? = {},
    onValueChanged: (String?) -> Unit
) {
    val containerColor1 = containerColor ?: grey2
    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = containerColor1,
            unfocusedContainerColor = containerColor1,
            disabledContainerColor = containerColor1,
            focusedBorderColor = md_theme_light_onPrimary,
            unfocusedBorderColor = md_theme_light_onPrimary,
        ),
        placeholder = {
            if (placeholderComposable != null) {
                placeholderComposable()
            } else {
                Text(
                    text = placeholder!!,
                    style = Typography.bodySmall.copy(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.W500,
                        color = placeholderColor ?: grey3
                    )
                )
            }
            Text(
                text = placeholder!!,
                style = Typography.bodySmall.copy(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = grey3
                )
            )
        },
        shape = ShapeDefaults.Medium,
        modifier = modifier,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    painter = painterResource(id = it),
                    tint = grey3,
                    contentDescription = "leading icon",
                )
            }

        },
        value = value,
        onValueChange = { newValue ->
            onValueChanged(newValue)
        },
    )
}