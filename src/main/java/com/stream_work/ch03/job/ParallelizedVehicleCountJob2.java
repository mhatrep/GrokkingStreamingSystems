package com.stream_work.ch03.job;

import com.stream_work.ch03.api.Job;
import com.stream_work.ch03.api.Stream;
import com.stream_work.ch03.engine.JobStarter;

public class ParallelizedVehicleCountJob2 {

  public static void main(String[] args) {
    Job job = new Job("parallelized_vehicle_count");

    Stream bridgeStream = job.addSource(new Bridge("bridge", 1, 9990));
    // Shuffle grouping is the default grouping strategy.
    bridgeStream.applyOperator(new TollBooth("booth", 2));

    System.out.println("This is a streaming job that counts vehicles from the input stream " +
            "in real time. Please enter vehicle types like 'car' and 'truck' in the " +
            "input terminal and look at the output");
    JobStarter starter = new JobStarter(job);
    starter.start();
  }
}