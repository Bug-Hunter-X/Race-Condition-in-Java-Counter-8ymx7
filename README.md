# Java Counter with Race Condition

This repository demonstrates a subtle race condition in a seemingly simple Java counter.  Even though the `increment()` method uses `synchronized`, the `getCount()` method does not, leading to inconsistent results when multiple threads access the counter concurrently.

## Bug Description
The `Counter` class attempts to increment a counter using two threads.  While `increment()` is synchronized to prevent race conditions during incrementing, `getCount()` lacks synchronization. Therefore, one thread might read the count before the other thread's increment has completed. This results in an inaccurate final count.

## Solution
The solution involves synchronizing the `getCount()` method to ensure thread safety.