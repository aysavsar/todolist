
# To-Do List Uygulaması
Bu proje, Java Spring Boot kullanılarak geliştirilmiş bir yapılacaklar listesi uygulamasıdır. Uygulama, kullanıcıların görevlerini oluşturmasına, güncellemesine, listelemesine ve silmesine olanak tanıyan RESTful API'ler sunar. Ayrıca, API dokümantasyonu için Swagger UI entegrasyonu içerir.

![Swagger UI Görseli](https://github.com/aysavsar/todolist/blob/main/screenshot%20(1).png)

# Kullanılan Teknolojiler

Java 17: Uygulama geliştirmek için kullanılan temel programlama dili.

Spring Boot: RESTful API geliştirme ve bağımlılık yönetimi.

Spring Data JPA: Veritabanı işlemlerini kolaylaştırmak için.

PostgreSQL Database: Güçlü ve ölçeklenebilir bir ilişkisel veritabanı çözümü.

Swagger UI: API dokümantasyonu ve test aracı.

Docker: Uygulamayı konteynerize etmek ve taşınabilirliğini artırmak için.

Docker Compose: Birden fazla servisin kolayca yönetilmesini sağlamak için.


#Özellikler

CRUD işlemleri (Görev oluşturma, güncelleme, listeleme ve silme).

Swagger UI ile API dokümantasyonu.

Docker ile hızlı kurulum ve taşıma.

PostgreSQL ile güçlü ve güvenilir veritabanı.

# Kurulum

### 1. Docker ile Hızlı Kurulum

Bu projeyi Docker kullanarak çalıştırabilirsiniz.

1. **Projeyi klonlayın:**
    ```bash
    git clone https://github.com/aysavsar/todolist.git
    cd todolist
    ```

2. **Docker imajını oluşturun ve başlatın:**
    ```bash
    docker-compose up --build
    ```

3. **Uygulamayı çalıştırın:**  
   Uygulama varsayılan olarak `http://localhost:8081` adresinde çalışacaktır. Swagger arayüzüne erişmek için:
    ```bash
    http://localhost:8081/swagger-ui/index.html#/
    ```

### 2. Manuel Kurulum (Docker kullanmadan)

1. **Projeyi klonlayın:**
    ```bash
    git clone https://github.com/aysavsar/todolist.git
    cd todolist
    ```

2. **Gerekli bağımlılıkları yükleyin ve projeyi derleyin:**
    ```bash
    ./mvnw clean install
    ```

3. **PostgreSQL'i yapılandırın:**  
   PostgreSQL'in yüklü ve çalışıyor olduğundan emin olun. `application.properties` dosyasındaki aşağıdaki bilgileri güncelleyin:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

4. **Uygulamayı başlatın:**
    ```bash
    ./mvnw spring-boot:run
    ```

   Uygulama varsayılan olarak `http://localhost:8081` adresinde çalışacaktır.

# API Dokümantasyonu

API uç noktalarını keşfetmek ve test etmek için Swagger UI kullanabilirsiniz. Swagger arayüzüne erişmek için tarayıcınızda şu URL'yi açın:

```bash
http://localhost:8081/swagger-ui/index.html#/
