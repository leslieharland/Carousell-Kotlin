package com.example.leslie.persistence.service

object ListingRepositoryProvider {
    fun provideSearchRepository(): ListingRepository {
        return ListingRepository(ListingService.create())
    }
}

object GroupRepositoryProvider {
    fun provideSearchRepository(): GroupRepository {
        return GroupRepository(GroupService.create())
    }
}
