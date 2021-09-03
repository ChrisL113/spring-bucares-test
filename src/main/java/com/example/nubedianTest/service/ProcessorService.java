package com.example.nubedianTest.service;

import com.example.nubedianTest.dto.ProcessorDto;
import com.example.nubedianTest.mapper.ProcessorMapper;
import com.example.nubedianTest.model.Processor;
import com.example.nubedianTest.repository.ProcessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ProcessorService {
    private final ProcessorRepository processorRepository;
    private final ProcessorMapper processorMapper;

    @Transactional
    public void createProcessor(ProcessorDto processorDto) {//Crud
        System.out.println(processorDto.toString());
        Processor processor = new Processor();
        processor.setModel(processorDto.getModel());
        processor.setBrand(processorDto.getBrand());
        processor.setSocket(processorDto.getSocket());
        processor.setClockSpeed(processorDto.getClockSpeed());
        processor.setNumberOfCores(processorDto.getNumberOfCores());
        processor.setNumberOfThreads(processorDto.getNumberOfThreads());
        processor.setTDP(processorDto.getTDP());
        processor.setEUR(processorDto.getEUR());





        processorRepository.save(processor);

    }

    @Transactional(readOnly = true)
    public List<ProcessorDto> getAllProcessors() {//cRud
        return processorRepository.findAll().stream()
                .map(processorMapper::mapProcessorToDto).collect(toList());
    }

    @Transactional
    public void updateProcessor(ProcessorDto processorDto){//crUd

        Optional<Processor> auxProcessor =
                processorRepository.findById(processorDto.getModel());
        Processor processor = processorMapper.mapDtoToProcessor(processorDto);
        processor.markUpdate();
        processorRepository.save(processor);
    }

    @Transactional
    public void deleteProcessor(String model){//cruD
        processorRepository.deleteById(model);
    }

}
