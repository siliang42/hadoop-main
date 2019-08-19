/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.hadoop.mapreduce.v2.app.job.event;

import org.apache.hadoop.mapreduce.v2.api.records.TaskAttemptId;


public class TaskAttemptKillEvent extends TaskAttemptEvent {

  private final String message;
  // Next map attempt will be rescheduled(i.e. updated in ask with higher
  // priority equivalent to that of a fast fail map)
  private final boolean rescheduleAttempt;

  public TaskAttemptKillEvent(TaskAttemptId attemptID,
      String message, boolean rescheduleAttempt) {
    super(attemptID, TaskAttemptEventType.TA_KILL);
    this.message = message;
    this.rescheduleAttempt = rescheduleAttempt;
  }

  public TaskAttemptKillEvent(TaskAttemptId attemptID,
      String message) {
    this(attemptID, message, false);
  }

  public String getMessage() {
    return message;
  }

  public boolean getRescheduleAttempt() {
    return rescheduleAttempt;
  }
}
