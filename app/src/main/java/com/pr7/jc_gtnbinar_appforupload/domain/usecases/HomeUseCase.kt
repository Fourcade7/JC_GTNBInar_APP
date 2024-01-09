package com.pr7.jc_gtnbinar_appforupload.domain.usecases

import com.pr7.jc_gtnbinar_appforupload.data.model.firebase.User
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.user.UserR
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    val homeRepository: HomeRepository
) {





   fun getUserData(token: String): Flow<Result<UserR?>> {
       return homeRepository.getUserData(token)
   }


}