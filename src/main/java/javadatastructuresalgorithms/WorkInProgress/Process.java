/**************************************************************************************************
 * Copyright [2018] [Martin Kelly]                                                                *
 *                                                                                                *
 * Licensed under the Apache License, Version 2.0 (the "License");                                *
 * you may not use this file except in compliance with the License.                               *
 * You may obtain a copy of the License at                                                        *
 *                                                                                                *
 * http://www.apache.org/licenses/LICENSE-2.0                                                     *
 *                                                                                                *
 * Unless required by applicable law or agreed to in writing, software                            *
 * distributed under the License is distributed on an "AS IS" BASIS,                              *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                       *
 * See the License for the specific language governing permissions and                            *
 * limitations under the License.                                                                 *
 **************************************************************************************************/

package src.main.java.javadatastructuresalgorithms.WorkInProgress;

public class Process<V> {

    private V task;
    private int ID;
    private int runTime;
    private int priority;
    private boolean waiting = false;
    private boolean running = false;

    public Process(V task, int ID, int runTime) {
        setID(ID);
        setTask(task);
        setRunTime(runTime);
    }

    public Process() {
        setID(ID);
        setTask(task);
        setRunTime(runTime);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTask(V task) {
        this.task = task;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getID() {
        return ID;
    }

    public V getTask() {
        return task;
    }

    public int getPriority(){
        return priority;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setToWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public void setToRunning(boolean running) {
        this.running = running;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isEmpty() {
        if(task == null) {
            return true;
        }
        return false;
    }

    /*
    public void Running() {
        setIsRunning(true);
        setPriority(0);
        while(isRunning()) {
            runTime++;
            if(runTime == 100) {
                break;
            }
        }
    }

    public void Waiting() {
        setIsWaiting(true);
        while(isWaiting()) {
            priority++;
            if(priority == 500) {

            }
        }
    }
    */
}
