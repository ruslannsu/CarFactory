package threadpool;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private LinkedBlockingQueue<Task> tasks = new LinkedBlockingQueue<>(30);
    private ArrayList<Thread> threads = new ArrayList<>();
    public void addThread(TaskExecuter taskExecuter) {
        threads.add(taskExecuter);
    }
    public LinkedBlockingQueue<Task> getTasks() {
        return tasks;
    }
    public void addTask(Task task) {
        try {
            tasks.offer(task);
        }
        catch (Exception ex)
        {
            throw new RuntimeException();
        }

    }
    public void threadPoolRun() {
        for (Thread thread: threads) {
            thread.start();
        }
    }
}
