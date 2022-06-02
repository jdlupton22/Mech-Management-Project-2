package services;

import entities.Picture;

import java.util.List;

public interface PictureService {
    public Picture createPicture(Picture p);

    public Picture readPicture(int id);

    public List<Picture> readAllPictures();

    public Picture updatePicture(Picture change);

    public Picture deletePicture(int id);
}
