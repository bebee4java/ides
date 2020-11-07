package tech.ides.job

import java.util.UUID

/**
  * 脚本作业管理器
  * Created by songgr on 2020/10/23.
  */
object ScriptJobManager {

  def newJob(owner: String,
             jobType: String,
             jobName: String,
             jobContent: String,
             timeout: Long):ScriptJobInfo = {
    val scriptJobType = ScriptJobType.withName(jobType)
    val groupId = nextGroupId
    val startTime = System.currentTimeMillis()
    ScriptJobInfo(owner,scriptJobType, jobName, jobContent, groupId, ScriptJobProgress(), startTime, timeout)
  }

  def nextGroupId = UUID.randomUUID().toString


}
