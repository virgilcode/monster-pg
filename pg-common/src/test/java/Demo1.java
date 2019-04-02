import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Starstar Sun
 * @date 2018/8/16 15:07
 * @Description:
 **/
public class Demo1 {

    @Test
    public void test1() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(JSON.toJSONString(map));
        map.put(3, 3);
        map.computeIfAbsent(3, a -> {
            return 4;
        });
        System.out.println(JSON.toJSONString(map));

    }

    @Test
    public void test2() {
        RateLimiter rateLimiter = RateLimiter.create(1000);
        System.out.println(rateLimiter.tryAcquire());
        System.out.println(rateLimiter.tryAcquire());
        System.out.println(rateLimiter.tryAcquire());
        System.out.println(rateLimiter.tryAcquire());

    }

    @Test
    public void testFuture() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println("task doing ...");
            try {
                Thread.sleep(3000);
//                System.out.println(1 / 0);
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
            completableFuture.complete("ok");
        }).start();
        String result = completableFuture.get(1000, TimeUnit.MICROSECONDS);
//        String result = completableFuture.get();
        System.out.println("计算结果:" + result);
    }

    @Test
    public void testListFuture() {
        Long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), executorService)
                        .thenApply(h -> Integer.toString(h))
                        .whenComplete((s, e) -> {
                            System.out.println("任务" + s + "完成!result=" + s + "，异常 e=" + e + "," + new Date());
                            list.add(s);
                        })
                ).toArray(CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(cfs).join();
        System.out.println("list=" + list + ",耗时=" + (System.currentTimeMillis() - start));
    }

    private static Integer calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Test
    public void testLambda() {
        Predicate<String> predicate1 = (x) -> x.length() > 2;
        System.out.println(predicate1.test("pg13"));
        System.out.println(predicate1.test("pg"));

        Supplier<String> supplier1 = () -> "pg13";
        System.out.println(supplier1.get());

        Consumer<String> consumer1 = (x) -> System.out.println("hello " + x);
        consumer1.accept("pg13");

        Function<Integer, String> function1 = (x) -> "hello " + x;
        System.out.println(function1.apply(10));
    }

    @Test
    public void test3(){
        int a=1;
        int b=a=a+10;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return 10;
        });
        CompletableFuture<String> future = completableFuture.thenApply(i -> i + 1).thenApply(i -> String.valueOf(i));
        System.out.println(future.get());
        System.out.println(completableFuture.hashCode());
        System.out.println(future.hashCode());

    }


    @Test
    public void test5(){
        ArrayList<Employee> employees = new ArrayList<>();
        String[] prefix = {"A", "B"};
        for (int i = 1; i <= 10; i++)
            employees.add(new Employee(prefix[i % 2] + i, i * 1000));

        employees.forEach(new SalaryConsumer());
    }

    static class Employee {
        private String name;
        private int salary;
        public Employee() {
            this.salary = 4000;
        }

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append("name:").append(name)
                    .append(",salary:").append(salary)
                    .toString();
        }
    }

    // 输出需要交税的员工
    static class SalaryConsumer implements Consumer<Employee> {

        @Override
        public void accept(Employee employee) {
            if (employee.getSalary() > 2000) {
                System.out.println(employee.getName() + "要交税了.");
            }
        }

    }




}


