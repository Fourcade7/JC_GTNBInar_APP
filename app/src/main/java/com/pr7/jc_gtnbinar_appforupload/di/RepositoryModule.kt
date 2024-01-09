package com.pr7.jc_gtnbinar_appforupload.di

import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.AuthRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.HomeAdminRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.HomeRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.OrderAdminRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.PlanAdminRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.PlanRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.data.repositoryimpl.SendRepositoryImpl
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.AuthRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeAdminRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.HomeRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.OrderAdminRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanAdminRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.PlanRepository
import com.pr7.jc_gtnbinar_appforupload.domain.repositiory.SendRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module

@InstallIn(SingletonComponent::class)

interface RepositoryModule {




    @Binds
    fun provideOrderAdminRepository(impl: OrderAdminRepositoryImpl):OrderAdminRepository
    @Binds
    fun provideSendRepository(impl: SendRepositoryImpl):SendRepository
    @Binds
    fun providePlanRepository(impl: PlanRepositoryImpl):PlanRepository
    @Binds
    fun provideHomeRepository(impl: HomeRepositoryImpl):HomeRepository
    @Binds
    fun provideAuthRepository(impl: AuthRepositoryImpl):AuthRepository

    @Binds
    fun providePlanAdminRepository(impl: PlanAdminRepositoryImpl):PlanAdminRepository
    @Binds
    fun provideHomeAdminRepository(impl: HomeAdminRepositoryImpl):HomeAdminRepository
}