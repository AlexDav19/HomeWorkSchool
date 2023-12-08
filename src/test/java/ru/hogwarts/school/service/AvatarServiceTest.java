package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvatarServiceTest {

    @Mock
    AvatarRepository avatarRepository;

    @InjectMocks
    AvatarService avatarService;

    @Test
    public void uploadAvatar() {
    }

    @Test
    public void generateImageData() {

    }

    @Test
    public void findAvatar() {
        Student student = new Student(1L, "sfsdf", 34);
        Avatar expected = new Avatar(1L, "asd", 2L, "wdwd", new byte[]{1, 2, 4}, student);
        when(avatarRepository.findByStudentId(1L)).thenReturn(Optional.of(expected));
        Avatar actual = avatarService.findAvatar(expected.getId());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllAvatars() {
        List<Avatar> expected = new ArrayList<>();
        Student student = new Student(1L, "sfsdf", 34);
        Avatar avatar = new Avatar(1L, "asd", 2L, "wdwd", new byte[]{1, 2, 4}, student);
        expected.add(avatar);

        when(avatarRepository.findAll(any(PageRequest.class)).getContent()).thenReturn(expected);
        List<Avatar> actual = avatarService.getAllAvatars(1, 1);
        Assertions.assertEquals(expected, actual);

    }
}
