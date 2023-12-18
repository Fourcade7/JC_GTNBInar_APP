package com.pr7.jc_gtnbinar_app.domain.usecases

import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    val homeRepository: HomeRepository
) {




   fun getUserData(uid: String): Flow<String>{
       return homeRepository.getUserData(uid)
   }


}