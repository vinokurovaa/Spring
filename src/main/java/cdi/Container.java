package cdi;


public interface Container {
    Object getDependency(String key);
}
