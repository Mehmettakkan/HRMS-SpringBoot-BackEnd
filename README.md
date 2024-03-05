# HRMS (Human Resource Management System) Projesi Raporu

## Temel Amacı
HRMS (Human Resource Management System - İnsan Kaynakları Yönetim Sistemi), işverenlerin iş ilanlarını yayınlamasına, adayların başvurularını yapmasına ve işverenlerin bu başvuruları değerlendirmesine olanak sağlayan bir yazılım projesidir. Bu projenin amacı, insan kaynakları süreçlerini dijital ortama taşımak ve bu süreçleri daha verimli bir şekilde yönetmektir.


## Kullanılan Teknolojiler
- Java
- Spring Framework (Spring Boot, Spring Data JPA)
- Hibernate
- Lombok
- PostgreSQL
- Swagger


## Katmanlar
1. Veri Erişim Katmanı (Data Access Layer)
2. İş Mantığı Katmanı (Business Logic Layer)
3. API Katmanı (API Layer)
4. Çekirdek (Core) Katmanı


## Öne çıkan özellikler
- İş ilanı yayınlama ve iş başvurusu alma
- İş arayanların CV oluşturma ve güncelleme imkanı
- İşverenlerin iş ilanı oluşturma ve yönetme
- İş arayanların iş başvurularını takip etme
- Sisteme kayıtlı kullanıcıların yönetimi (ekleme, silme, güncelleme)
- Güvenlik önlemleri (örneğin, şifre doğrulama)
- Veri doğrulama (örneğin, e-posta doğrulama)
- Mernis entegrasyonu ile kullanıcıların gerçek kimlik bilgilerinin doğrulanması
- API üzerinden iş ilanı ve iş başvurusu yönetimi


## Panel Özellikleri
- İşveren Paneli: İş ilanı oluşturma, iş ilanı yönetimi
- İş Arayan Paneli: CV oluşturma, iş başvurusu yapma, başvuruları takip etme
- Admin Paneli: Sistem yöneticileri tarafından sistem genelinde yapılan ayarlar ve kullanıcı yönetimi

## Teknik Özellikler
- Restful API kullanımı
- ORM (Object-Relational Mapping) kullanımı Hibernate ile sağlanmıştır.
- Veri tabanı olarak PostgreSQL tercih edilmiştir.
- MVC (Model-View-Controller) mimarisi kullanılmıştır.
- Swagger ile API belgeleri oluşturulmuştur.


## Temel Katmanlar ve İşlevleri
- Veri Erişim Katmanı (Data Access Layer): Veritabanı işlemleri için JPA Repository kullanılmıştır.
- İş Mantığı Katmanı (Business Logic Layer): İş kuralları ve iş süreçleri bu katmanda yönetilir.
- API Katmanı (API Layer): Restful API'lerin tanımlandığı katmandır.
- Çekirdek (Core) Katmanı: Temel işlevlerin ve yardımcı sınıfların yer aldığı katmandır.


## Veri Modeli
- Kullanıcılar: Sistemdeki tüm kullanıcıları temsil eder. İş arayanlar, işverenler ve sistem yöneticileri bu kategoriye girer.
- İş Pozisyonları: İş ilanlarını temsil eder.
- İş Arayanlar: Sistemde kayıtlı olan iş arayan kullanıcıları temsil eder.
- İşverenler: Sistemde kayıtlı olan işveren kullanıcıları temsil eder.
- CV: İş arayanların özgeçmiş bilgilerini tutar.

  
<img width="1440" alt="HRMS-Swagger" src="https://github.com/Mehmettakkan/HRMS-SpringBoot-BackEnd/assets/114080733/5bc262d3-b621-4fce-b2cb-03c6ce05469f">

