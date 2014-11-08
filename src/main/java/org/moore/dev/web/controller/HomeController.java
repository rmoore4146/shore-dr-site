package org.moore.dev.web.controller;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import org.moore.dev.model.ShorePhoto;
import org.moore.dev.web.controller.util.MobileDeviceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 1/25/14
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {

    @Value("${flickr.api.key}") String flickrApiKey;
    @Value("${flickr.api.secret}") String flickrSecret;


//    Logger logger = Logger.getLogger(WeddingController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getNakedURLRedirectPage(ModelMap map, HttpServletRequest request) {
        return "forward:home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(ModelMap map, HttpServletRequest request) {
        MobileDeviceUtil.addMobileDeviceFlagToModel(map, request);
        return "home";
    }

    @RequestMapping(value = "/before", method = RequestMethod.GET)
    public String getBeforePage(ModelMap map, HttpServletRequest request) {
        MobileDeviceUtil.addMobileDeviceFlagToModel(map, request);
        Flickr flickr = new Flickr(flickrApiKey, flickrSecret, new REST());
        // Set the wanted search parameters (I'm not using real variables in the example)
        SearchParameters searchParameters = new SearchParameters();
        String[] tags = {"before"};
        searchParameters.setTags(tags);
        searchParameters.setUserId("128173886@N02");

        try {
            PhotoList<Photo> list = flickr.getPhotosInterface().search(searchParameters, 0, 0);
            map.addAttribute("photos", getShorePhotos(list));
        } catch (FlickrException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return "before";
    }

    @RequestMapping(value = "/after", method = RequestMethod.GET)
    public String getAfterPage(ModelMap map, HttpServletRequest request) {
        MobileDeviceUtil.addMobileDeviceFlagToModel(map, request);
        return "after";
    }

    @RequestMapping(value = "/rebuild", method = RequestMethod.GET)
    public String getRebuildPage(ModelMap map, HttpServletRequest request) {
        MobileDeviceUtil.addMobileDeviceFlagToModel(map, request);
        return "rebuild";
    }

    private List<ShorePhoto> getShorePhotos(PhotoList<Photo> flickrPhotos) {
        List<ShorePhoto> shorePhotos = new ArrayList<>();
        for (Photo flickrPhoto : flickrPhotos) {
            ShorePhoto temp = new ShorePhoto();
            temp.setDescription(flickrPhoto.getDescription());
            temp.setTitle(flickrPhoto.getTitle());
            String urlString = "https://farm" + flickrPhoto.getFarm() + ".staticflickr.com/" + flickrPhoto.getServer() + "/" + flickrPhoto.getId() + "_" + flickrPhoto.getSecret() + "_c." + flickrPhoto.getOriginalFormat();
            temp.setUrl(urlString);
            String urlStringThumb = "https://farm" + flickrPhoto.getFarm() + ".staticflickr.com/" + flickrPhoto.getServer() + "/" + flickrPhoto.getId() + "_" + flickrPhoto.getSecret() + "_s." + flickrPhoto.getOriginalFormat();
            temp.setUrlSmall(urlStringThumb);
            shorePhotos.add(temp);

        }
        return shorePhotos;
    }
}
