package com.pr7.jc_gtnbinar_app.di

import com.pr7.jc_gtnbinar_app.domain.repositiory.AuthRepository
import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeAdminRepository
import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeRepository
import com.pr7.jc_gtnbinar_app.domain.repositiory.PlanAdminRepository
import com.pr7.jc_gtnbinar_app.domain.usecases.AuthUseCase
import com.pr7.jc_gtnbinar_app.domain.usecases.HomeAdminUseCase
import com.pr7.jc_gtnbinar_app.domain.usecases.HomeUseCase
import com.pr7.jc_gtnbinar_app.domain.usecases.PlanAdminUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {



    @Provides
    fun provideHomeUseCase(homeRepository: HomeRepository)=HomeUseCase(homeRepository)
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository)=AuthUseCase(authRepository)
    @Provides
    fun providePlanAdminUseCase(planAdminRepository: PlanAdminRepository)=PlanAdminUseCase(planAdminRepository)

    @Provides
    fun provideHomeAdminUseCase(homeAdminRepository: HomeAdminRepository)=HomeAdminUseCase(homeAdminRepository)
}