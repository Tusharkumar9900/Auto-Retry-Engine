# Auto Retry Engine — Spring Boot + AOP <br>
A lightweight, annotation-based Auto Retry Engine built using Spring Boot + Aspect-Oriented Programming (AOP).
This engine automatically retries failed method executions (API calls, DB operations, external integrations, etc.) without writing repetitive try-catch logic.

Perfect for resilient microservices, external API calls, and fault-tolerant systems. <br>

## Features
🌀 Annotation-based retry using @AutoRetry <br>
🔁 Configurable retry attempts <br>
⏱ Adjustable delay between retries <br>
🛡 Avoids nested try-catch boilerplate <br>
🧠 Works with any service method <br>
📦 Built with clean AOP architecture <br>
💡 Simple, reusable, production-ready pattern <br>

## How It Works
### Aspect automatically intercepts failed calls <br>
If the method throws an exception <br>
The AOP aspect re-executes it automatically <br>
With delay + logging <br>
Until attempts are exhausted <br>

### If all retries fail → last exception is thrown
