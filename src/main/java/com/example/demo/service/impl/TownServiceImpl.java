package com.example.demo.service.impl;

import com.example.demo.dto.TownDTO;
import com.example.demo.entity.Town;
import com.example.demo.repo.TownRepo;
import com.example.demo.service.TownService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TownServiceImpl implements TownService {
    private final TownRepo townRepo;
    private final ModelMapper modelMapper;

   // private final Logger log= LoggerFactory.getLogger(TownServiceImpl.class);
   @Autowired
    private TownServiceImpl(TownRepo townRepo, ModelMapper modelMapper){
        this.townRepo = townRepo;
        this.modelMapper = modelMapper;

    }

    @Override
    public TownDTO getTown(UUID id) {
      return modelMapper.map(townRepo.findTownByTownId(id),TownDTO.class);
    }

    @Override
    public boolean delete(String id) {
        try {
            townRepo.deleteById(UUID.fromString(id));
            return true;
        }catch (Exception e){

            //log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public TownDTO save(TownDTO input) {
        Town save = townRepo.save(modelMapper.map(input, Town.class));
       return  modelMapper.map(save, TownDTO.class);
    }

    @Override
    public TownDTO update(TownDTO input) {


        if(!townRepo.existsById(input.getTownId())){
         throw  new RuntimeException("id not found");
        }else {
            Town map = modelMapper.map(input, Town.class);
           return modelMapper.map(townRepo.save(map), TownDTO.class);
        }

    }

    @Override
    public List<TownDTO> getAll() {
        return townRepo.findAll().stream().map(town -> modelMapper.map(town,TownDTO.class)).collect(Collectors.toList());
    }


}
