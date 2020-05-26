package ru.af.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.af.dao.entity.User;
import ru.af.dao.entity.Word;
import ru.af.dao.repo.UserRepository;
import ru.af.dao.repo.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final UserRepository userRepository;

    @Autowired
    public WordService(WordRepository wordRepository, UserRepository userRepository) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
    }

    public Word convertToWord(WordDto wordDto){
        Word word = new Word();
        word.setBody(wordDto.getValue());
        return word;
    }

    public WordDto convertToWordDto(Word word){
        WordDto dtoWord = new WordDto();
        dtoWord.setValue(word.getBody());
        return dtoWord;
    }

    public void saveWord(WordDto wordDto, String userName){
        User user = userRepository.findByName(userName);
        Word word= new Word();
        word.setBody(wordDto.getValue());
        word.setUserId(user.getId());
        wordRepository.save(word);
    }

    public List<WordDto> getAllWordsByUser(String userName){
        List<WordDto> dtoWords = new ArrayList<>();
        User user = userRepository.findByName(userName);
        List<Word> wordList= wordRepository.findByUserId(user.getId());
        for (Word word : wordList) {
            dtoWords.add(convertToWordDto(word));
        }
        return dtoWords;
    }


}
