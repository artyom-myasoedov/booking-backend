package booking.backend.rest.api;

import booking.backend.service.logic.PhotoService;
import booking.backend.service.model.PhotoCreateDto;
import booking.backend.service.model.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

  private final PhotoService photoService;

  @Autowired
  public PhotoController(PhotoService photoService) {
    this.photoService = photoService;
  }

  @GetMapping("/{photoId}")
  public PhotoDto getPhoto(
    @PathVariable Integer photoId) {
    return photoService.findById(photoId);
  }

  @DeleteMapping("/{photoId}")
  public void deletePhoto(
    @PathVariable Integer photoId) {
    photoService.deleteById(photoId);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public PhotoDto updatePhoto(@RequestBody PhotoDto photo) {
    return photoService.updatePhoto(photo);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public PhotoDto addPhoto(@RequestBody PhotoCreateDto photo) {
    return photoService.addPhoto(photo);
  }

  @GetMapping("/byRoomId")
  @ResponseStatus(HttpStatus.OK)
  public List<PhotoDto> getPhotosByRoomId(
    @RequestParam Integer roomId) {
    return photoService.findByRoomId(roomId);
  }
}
