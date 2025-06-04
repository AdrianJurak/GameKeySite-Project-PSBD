package pl.studia.GameKeySite_Project_PSBD.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.studia.GameKeySite_Project_PSBD.model.dto.GameDto;
import pl.studia.GameKeySite_Project_PSBD.model.dto.PublisherDto;
import pl.studia.GameKeySite_Project_PSBD.model.dto.ReviewDto;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // --- CONTROLLERS ---
    @Before("execution(* pl.studia.GameKeySite_Project_PSBD.controller..*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        logger.fine("Entering method: " + joinPoint.getSignature().toShortString()
                + " with arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* pl.studia.GameKeySite_Project_PSBD.controller.*.*(..))",
            returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        logger.fine("Method completed: " + joinPoint.getSignature().toShortString()
                + " with result: " + result);
    }

    // --- SERVICES ---
    @Before("execution(* pl.studia.GameKeySite_Project_PSBD.service..*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        logger.fine("Service method called: " + joinPoint.getSignature().toShortString()
                + " with arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(* pl.studia.GameKeySite_Project_PSBD.service.ReviewService.create(..))",
            returning = "reviewDto")
    public void logReviewCreated(ReviewDto reviewDto) {
        logger.info("Review created with id: " + reviewDto.getId()
                + ", gameId: " + reviewDto.getGameId()
                + ", rating: " + reviewDto.getStars());
    }

    @AfterReturning(value = "execution(* pl.studia.GameKeySite_Project_PSBD.service.PublisherService.create(..))",
            returning = "publisherDto")
    public void logPublisherCreated(PublisherDto publisherDto) {
        logger.info("Publisher created with id: " + publisherDto.getId()
                + ", name: " + publisherDto.getName());
    }

    @AfterReturning(value = "execution(* pl.studia.GameKeySite_Project_PSBD.service.GameService.create(..))",
            returning = "gameDto")
    public void logGameCreated(GameDto gameDto) {
        logger.info("Game created with id: " + gameDto.getId()
                + ", title: " + gameDto.getName()
                + ", genre: " + gameDto.getGenre()
                + ", platform: " + gameDto.getPlatform());
    }

    @AfterReturning(value = "execution(* pl.studia.GameKeySite_Project_PSBD.service.*Service.getAll(..))",
            returning = "list")
    public void logGetAll(JoinPoint joinPoint, Object list) {
        int size = (list instanceof Collection<?> collection) ? collection.size() : -1;
        logger.fine("Method " + joinPoint.getSignature().toShortString()
                + " returned a collection of size: " + size);
    }

    // --- EXCEPTION ---
    @AfterThrowing(value = "execution(* pl.studia.GameKeySite_Project_PSBD.service.*Service.getById(..))",
            throwing = "ex")
    public void logGetByIdException(JoinPoint joinPoint, Exception ex) {
        logger.warning("An exception occurred in method: " + joinPoint.getSignature().toShortString()
                + " with message: " + ex.getMessage());
    }

}
