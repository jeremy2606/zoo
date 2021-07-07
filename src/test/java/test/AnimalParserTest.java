package test;

import dbaccess.AnimalDTO;
import model.Animal;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import parsers.AnimalParser;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AnimalParserTest {

    @Mock
    private AnimalDTO mockedAnimalDTO;

    @Mock
    private Animal mockedAnimal;

    @Test
    public void DTOtoAnimalTest() {

        AnimalParser parser = new AnimalParser();

        when(mockedAnimalDTO.getId()).thenReturn(12);
        when(mockedAnimalDTO.getName()).thenReturn("Micha");
        when(mockedAnimalDTO.getTypeAnimalId()).thenReturn(2);
        when(mockedAnimalDTO.getEnclosId()).thenReturn(1);
        when(mockedAnimalDTO.getCommentaires()).thenReturn("ceci est le commentaire");

        Animal tested = parser.DTOtoAnimal(mockedAnimalDTO);
        assertAll(
                () -> assertEquals("Micha", tested.getPrenom()),
                () -> assertEquals("ours", tested.getRace()),
                () -> assertEquals("standard", tested.getTypeEnclos()),
                () -> assertEquals("ceci est le commentaire", tested.getCommentaires()));
    }

    public void animalToDTOTest() {
    }

}
