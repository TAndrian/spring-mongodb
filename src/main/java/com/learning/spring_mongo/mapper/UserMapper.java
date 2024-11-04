package com.learning.spring_mongo.mapper;

import com.learning.spring_mongo.document.UserDocument;
import com.learning.spring_mongo.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    /**
     * Converts user document into user dto.
     *
     * @param userDocument target document to convert.
     * @return converted userDocument into UserDTO.
     */
    UserDTO toDTO(UserDocument userDocument);

    /**
     * Converts list of user documents into list of user dtos.
     *
     * @param userDocument target list of documents to convert.
     * @return converted list of userDocuments into list of UserDTOs.
     */
    List<UserDTO> toDTOs(List<UserDocument> userDocument);

    /**
     * Converts userDTO into userDocument.
     *
     * @param userDTO DTO to convert.
     * @return converted userDTO into userDocument.
     */
    UserDocument fromDTO(UserDTO userDTO);

    /**
     * Update UserDocument data with updateDTO data.
     *
     * @param updateDTO    update data.
     * @param userDocument target user to update.
     */
    void updateUserDocumentFromDTO(UserDTO updateDTO, @MappingTarget UserDocument userDocument);
}
