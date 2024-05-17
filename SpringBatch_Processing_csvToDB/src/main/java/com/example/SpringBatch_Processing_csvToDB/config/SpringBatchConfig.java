package com.example.SpringBatch_Processing_csvToDB.config;

import com.example.SpringBatch_Processing_csvToDB.entity.Customer;
import com.example.SpringBatch_Processing_csvToDB.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.File;


@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {
    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private CustomerRepository customerRepository;

//    @Bean
//    public FlatFileItemReader<Customer> reader() {
//        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
//        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
//        itemReader.setName("csvReader");
//        itemReader.setLinesToSkip(1);
//        itemReader.setLineMapper(lineMapper());
//        return itemReader;
//    }
    @Bean
    @StepScope
    public FlatFileItemReader<Customer> itemReader(@Value("#{jobParameters[fullpathfilename]}") String pathToFile) {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(new File(pathToFile)));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Job runJob(FlatFileItemReader<Customer> itemReader) {
        return jobBuilderFactory.get("importCustomers")
                .flow(step1(itemReader)).end().build();

    }
    @Bean
    public Step step1(FlatFileItemReader<Customer> itemReader) {
        return stepBuilderFactory.get("csv-step").<Customer, Customer>chunk(10)
//                .reader(reader())
                .reader(itemReader)
                .processor(processor())
                .writer(writer())
//                .taskExecutor(taskExecutor())
                .build();
    }
}
