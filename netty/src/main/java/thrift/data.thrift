namespace java thrift.genrated


/**
 *  @author zhangqi
 *  @date 2019/3/20 下午7:19
 */
 typedef i16 short
 typedef i32 int
 typedef i64 log
 typedef bool boolean
 typedef string String

 struct Person1{
       1: optional String username,
       2: optional int age,
       3: optional boolean married
 }
 exception DataException1{
 1:optional String message,
 2:optional String callStack,
 3:optional String date
 }
 service PersonService{
   Person1 getPersonByUsername(1:required String username) throws (1:DataException1 dataExceptipon),
   void savePerson(1:required Person1 person) throws (1:DataException1 e)
 }
 
    
    
    