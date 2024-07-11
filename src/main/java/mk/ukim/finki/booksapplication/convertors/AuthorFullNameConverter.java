package mk.ukim.finki.booksapplication.convertors;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import mk.ukim.finki.booksapplication.model.AuthorFullName;

@Converter
public class AuthorFullNameConverter implements AttributeConverter<AuthorFullName, String> {

    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(AuthorFullName authorFullName) {
        if (authorFullName == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (authorFullName.getSurname() != null && !authorFullName.getSurname().isEmpty()){
            stringBuilder.append(authorFullName.getSurname());
            stringBuilder.append(SEPARATOR);
        }

        if (authorFullName.getName() != null && !authorFullName.getName().isEmpty()) {
            stringBuilder.append(authorFullName.getName());
        }
        return stringBuilder.toString();
    }

    @Override
    public AuthorFullName convertToEntityAttribute(String dbAuthorFullName) {
        if (dbAuthorFullName == null || dbAuthorFullName.isEmpty()){
            return null;
        }

        String[] pieces = dbAuthorFullName.split(SEPARATOR);

        if (pieces == null || pieces.length == 0) {
            return null;
        }

        AuthorFullName fullName = new AuthorFullName();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if (dbAuthorFullName.contains(SEPARATOR)){
            fullName.setSurname(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null && !pieces[1].isEmpty()){
                fullName.setName(pieces[1]);
            }
        }else {
            fullName.setName(firstPiece);
        }
        return fullName;

    }
}