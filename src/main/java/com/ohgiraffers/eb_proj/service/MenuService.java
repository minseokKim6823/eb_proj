package com.ohgiraffers.eb_proj.service;

import com.ohgiraffers.eb_proj.dto.MenuDTO;
import com.ohgiraffers.eb_proj.entity.Menu;
import com.ohgiraffers.eb_proj.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final ModelMapper mapper;
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(ModelMapper mapper,MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
        this.mapper = mapper;
    }


    public MenuDTO findMenuByMenuCode(int menuCode) {

        Menu selectedMenu = menuRepository.findById(menuCode).orElseThrow(IllegalAccessError::new);

        return mapper.map(selectedMenu, MenuDTO.class);
    }
}
