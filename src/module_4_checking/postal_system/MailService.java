package module_4_checking.postal_system;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
public interface MailService {
    Sendable processMail(Sendable mail);

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

public static final String AUSTIN_POWERS = "Austin Powers";
public static final String WEAPONS = "weapons";
public static final String BANNED_SUBSTANCE = "banned substance";

public static class UntrustworthyMailWorker implements MailService {

    private final MailService[] mailServices;
    private final RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService mailService : mailServices) {
            mail = mailService.processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}

public static class Spy implements MailService {

    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailMessage.class) {
            String from = mail.getFrom();
            String to = mail.getTo();
            if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{from, to, ((MailMessage) mail).getMessage()});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{from, to});
            }
        }
        return null;
    }
}

public static class Thief implements MailService {

    private final int minStolePrice;
    private int stolenValue;

    public Thief(int minTheftPrice) {
        this.minStolePrice = minTheftPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailPackage.class) {
            Package pack = ((MailPackage) mail).getContent();

            if (!(pack.getPrice() < minStolePrice)) {
                stolenValue +=pack.getPrice();
                return new MailPackage(mail.getFrom(), mail.getTo(),
                        new Package(("stones instead of " + pack.getContent()), 0));
            }
        }
        return mail;
    }
}

public static class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailPackage.class) {
            String post = ((MailPackage) mail).getContent().getContent();

            if (post.contains(WEAPONS) || post.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if (post.contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}

public static class IllegalPackageException extends RuntimeException {}

public static class StolenPackageException extends RuntimeException {}


}
