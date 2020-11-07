package tech.ides.job

import tech.ides.job.ScriptJobType.jobType


/**
  * Created by songgr on 2020/11/06.
  */

/**
  * 脚本作业信息
  * @param owner 脚本所有者
  * @param jobType 脚本作业类型 batch/stream
  * @param jobName 作业名称
  * @param jobContent 脚本作业内容
  * @param groupId 作业groupId
  * @param progress 脚本作业进度
  * @param startTime 脚本作业开始时间
  * @param timeout 脚本作业超时时间(ms)
  */
case class ScriptJobInfo(
    owner: String,
    jobType: jobType,
    jobName: String,
    jobContent: String,
    groupId: String,
    progress: ScriptJobProgress,
    startTime: Long,
    timeout: Long
)

/**
  * 脚本作业类型
  */
object ScriptJobType extends Enumeration {
  type jobType = Value
  val BATCH = Value("batch")
  val STREAM = Value("stream")
}

/**
  * 脚本作业进度
  * @param totalJob 总共job数目
  * @param currentJobIndex 当前job索引
  * @param currentJobContent 当前job内容
  */
case class ScriptJobProgress(var totalJob:Int = 0, var currentJobIndex:Int = 0, var currentJobContent:String = "") {
  def increment = currentJobIndex += 1
}

