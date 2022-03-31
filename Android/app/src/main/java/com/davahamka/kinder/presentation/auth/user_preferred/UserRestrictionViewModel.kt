package com.davahamka.kinder.presentation.auth.user_preferred

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.davahamka.kinder.static.UserReferenceStatic
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class UserRestrictionViewModel @Inject constructor(

): ViewModel() {

    var dataOptions by mutableStateOf<List<String>>(emptyList())
        private set

    fun onEvent(event: UserRestrictionEvent) {
        when(event) {
            is UserRestrictionEvent.OnNextPage -> {

            }
            is UserRestrictionEvent.OnSelectOption -> {
                if (dataOptions.contains(event.choose)) {
                    dataOptions = dataOptions - event.choose
                } else {
                    dataOptions = dataOptions + event.choose
                }
                Log.d("DATAOPTION", dataOptions.toString())
            }
        }
    }
}