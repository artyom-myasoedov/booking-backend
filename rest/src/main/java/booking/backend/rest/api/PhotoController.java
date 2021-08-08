package booking.backend.rest.api;

import booking.backend.service.logic.PhotoService;
import booking.backend.service.model.PhotoCreateDto;
import booking.backend.service.model.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
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
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  public PhotoDto getPhoto(
    @PathVariable Integer photoId) {
    return photoService.findById(photoId);
  }

  @DeleteMapping("/{photoId}")
  @Secured("ROLE_LANDLORD")
  public void deletePhoto(
    @PathVariable Integer photoId) {
    photoService.deleteById(photoId);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @Secured("ROLE_LANDLORD")
  public PhotoDto updatePhoto(@RequestBody PhotoDto photo) {
    return photoService.updatePhoto(photo);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @Secured("ROLE_LANDLORD")
  public PhotoDto addPhoto(@RequestBody PhotoCreateDto photo) {
    return photoService.addPhoto(photo);
  }

  @GetMapping("/byRoomId")
  @ResponseStatus(HttpStatus.OK)
  @Secured({"ROLE_CLIENT", "ROLE_LANDLORD", "ROLE_ADMIN"})
  public List<PhotoDto> getPhotosByRoomId(
    @RequestParam Integer roomId) {
    return photoService.findByRoomId(roomId);
  }
}
