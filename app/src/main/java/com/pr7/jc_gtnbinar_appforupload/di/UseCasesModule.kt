package com.pr7.jc_gtnbinar_appforupload.di

import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.AuthRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeAdminRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.OrderAdminRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanAdminRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.SendRepository
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.AuthUseCase
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.HomeAdminUseCase
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.HomeUseCase
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.OrderAdminUseCase
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.PlanAdminUseCase
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.PlanUseCase
import com.pr7.jc_gtnbinar_appforupload.domain.usecases.SendUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module

@InstallIn(SingletonComponent::class)
class UseCasesModule {



    @Provides
    fun provideOrderAdminUseCase(orderAdminRepository: OrderAdminRepository)=OrderAdminUseCase(orderAdminRepository)
    @Provides
    fun provideSendUseCase(sendRepository: SendRepository)=SendUseCase(sendRepository)

    @Provides
    fun providePlanUseCase(planRepository: PlanRepository)=PlanUseCase(planRepository)
    @Provides
    fun provideHomeUseCase(homeRepository: HomeRepository)=HomeUseCase(homeRepository)
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository)=AuthUseCase(authRepository)
    @Provides
    fun providePlanAdminUseCase(planAdminRepository: PlanAdminRepository)=PlanAdminUseCase(planAdminRepository)

    @Provides
    fun provideHomeAdminUseCase(homeAdminRepository: HomeAdminRepository)=HomeAdminUseCase(homeAdminRepository)
}