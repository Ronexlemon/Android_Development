package com.example.mvm.Database

class SubRepository(private val subDao:SubScriberDAO) {

    val sub = subDao.getAl()

    suspend fun insertSub(subscriber:Subscriber){
        subDao.insert(subscriber)
    }
   suspend fun updateUser(subscriber: Subscriber){
        subDao.update(subscriber)
    }
   suspend fun deleteSub(){
        subDao.clear()
    }
}