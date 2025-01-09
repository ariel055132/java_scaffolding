# Java-Scaffolding-Sensitive
* Sensitive data encryption module.
* We need this module to desensitize sensitive data in our project.

## Usage
* There are some approaches to implement desensitize sensitive data in Java.
1. Using utility class in modules (Hutools is used for demo in this project.)
2. Hard-coded Approach
3. Annotation

## Utility class Approach
* You can use pre-defined function. Or you can define your own function to desensitize sensitive data.

## Hard-coded Approach
* Involves calling the methods provided by the above utility class in all spaces where desensitization is required.
* Advantage: Simple, easy to understand, and allows for a good assessment of the impact of changes.
* Downside: The code becomes highly coupled, and if there are many interfaces involved in desensitization, making changes can be a disaster.
* Only recommended where there are few interfaces involved in desensitization. 

## Annotation-based Approach
* Refers to achieving desensitization of interface data before it is return by executing the logic of a custom serializer.
* It requires adding custom annotations to fields to indicate that these fields need to be desensitized and specify the desensitization rules.
* Advantage: The code coupling is low, and the desensitization code is not coupled with the business code.
* Downside: It has a certain understanding cost and does not allow for a good assessment of the impact of changes.
* It should be the most appropriate approach.

### Steps to implement Annotation-based Approach
1. Define an enumeration for desensitization types. (Ref: DesensitizeType.java)
    * You should define the desensitization types you need.
2. Define a custom desensitization annotation. (Ref: Desensitize.java)
    * @Target(ElementType.FIELD): Ensure that the desensitization logic is only applied to the fields of a class.
    * @Retention(RetentionPolicy.RUNTIME): The annotation will be available for reflection at runtime, allowing the desensitization logic to be applied during the serialization process.
    * @JacksonAnnotationsInside: Indicates that the annotation can be used inside Jackson annotations. Help jackson to recognize this annotation and process the custom annotation correctly.
    * @JsonSerialize(using = DesensitizeSerializer.class): Define the custom serializer that will be used to process the annotated field.
3. Define a custom desensitization serializer. (Ref: DesensitizeSerializer.java)
    * You should implement the logic of desensitization in this class.