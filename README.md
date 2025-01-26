# Monitoring Service

## 📌 Описание

Этот проект реализует систему мониторинга публикаций с использованием шаблонов **Command, Observer и Singleton**.

### 🔹 Основные компоненты:

- **Команды (********`Command`********)** - инкапсулирует запросы на сохранение данных.
- **Очередь запросов (********`BlockingQueue`********)** - используется для обработки команд сервером.
- **Сервер (********`Server`********)** - извлекает команды из очереди и выполняет их.
- **База данных (********`Database`********)** - Singleton-объект для хранения событий.
- **Система подписок (********`Observer`********)** - уведомляет подписчиков о новых публикациях.
- **Клиенты (********`Client`********)** - создают запросы и отправляют их в очередь.

## 🚀 Функциональность

- Обработка событий в многопоточном режиме.
- Хранение событий в базе данных.
- Уведомление подписчиков о новых публикациях.
- Поддержка шаблона Команда для организации обработки событий.

## 🛠️ Технологии

- **Java 17+**
- **Lombok**
- **Многопоточность (BlockingQueue, Runnable)**
- **Паттерны проектирования (Command, Observer, Singleton)**

## 🔧 Установка

### 1️⃣ Установите зависимости

Убедитесь, что у вас установлен **Java 17+** и **Maven**.

## 📌 Как работает?

1. **Создание сервиса мониторинга** → `MonitoringService` запускает сервер и инициализирует очередь команд.
2. **Публикация событий** → Клиенты создают запросы на публикацию данных.
3. **Очередь команд** → Запросы отправляются в очередь команд.
4. **Сервер обрабатывает команды** → Сервер извлекает команды из очереди и выполняет их.
5. **Сохранение в БД** → Данные сохраняются в Singleton-объекте `Database`.
6. **Уведомление подписчиков** → Все подписчики (`Observer`) получают уведомление о новых публикациях.

###

