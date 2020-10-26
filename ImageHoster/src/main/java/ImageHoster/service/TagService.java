package ImageHoster.service;

import ImageHoster.model.Tag;
import ImageHoster.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    //This method gets a tag by tag name by calling the repository class method
    public Tag getTagByName(String title) {
        return tagRepository.findTag(title);
    }

    //This method persists the tag for an image by passing the data to repository
    public Tag createTag(Tag tag) {
        return tagRepository.createTag(tag);
    }
}
