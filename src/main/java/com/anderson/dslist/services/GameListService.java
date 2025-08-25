package com.anderson.dslist.services;


import com.anderson.dslist.DTO.GameListDTO;
import com.anderson.dslist.entities.GameList;
import com.anderson.dslist.projections.GameMinProjections;
import com.anderson.dslist.repositories.GameListRepository;
import com.anderson.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {


    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    // Esse é o metodo para, dado uma lista, vc trocar a posição de um game pela do outro
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjections> list = gameRepository.searchByList(listId);

        GameMinProjections obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex <destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex <destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++ ) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }


}
