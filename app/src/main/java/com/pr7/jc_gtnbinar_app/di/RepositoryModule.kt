package com.pr7.jc_gtnbinar_app.di

import com.pr7.jc_gtnbinar_app.data.repositoryimpl.AuthRepositoryImpl
import com.pr7.jc_gtnbinar_app.data.repositoryimpl.HomeAdminRepositoryImpl
import com.pr7.jc_gtnbinar_app.data.repositoryimpl.HomeRepositoryImpl
import com.pr7.jc_gtnbinar_app.data.repositoryimpl.PlanAdminRepositoryImpl
import com.pr7.jc_gtnbinar_app.domain.repositiory.AuthRepository
import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeAdminRepository
import com.pr7.jc_gtnbinar_app.domain.repositiory.HomeRepository
import com.pr7.jc_gtnbinar_app.domain.repositiory.PlanAdminRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {



    @Binds
    fun provideHomeRepository(impl: HomeRepositoryImpl):HomeRepository
    @Binds
    fun provideAuthRepository(impl: AuthRepositoryImpl):AuthRepository

    @Binds
    fun providePlanAdminRepository(impl: PlanAdminRepositoryImpl):PlanAdminRepository
    @Binds
    fun provideHomeAdminRepository(impl: HomeAdminRepositoryImpl):HomeAdminRepository
}