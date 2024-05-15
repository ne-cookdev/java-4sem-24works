package mirea4sem.task7.facade;

// Фасад для управления умным домом
class SmartHomeFacade {
    private Light lightSystem;
    private Security securitySystem;

    public SmartHomeFacade() {
        this.lightSystem = new LightSystem();
        this.securitySystem = new SecuritySystem();
    }

    // Методы для управления освещением через фасад
    public void turnLightsOn() {
        lightSystem.turnOn();
    }

    public void turnLightsOff() {
        lightSystem.turnOff();
    }

    // Методы для управления системой безопасности через фасад
    public void armSecurity() {
        securitySystem.arm();
    }

    public void disarmSecurity() {
        securitySystem.disarm();
    }
}
