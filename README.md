# Discord Webhook Manager

Create webhooks simply and easily

## Example Java
### 1. Send to content
```java
DiscordWebhook webhook = DiscordWebhook("WebhookURL");
webhook.setContent("Hello World!");
webhook.execute(); // return DiscordResponse
```

### 2. Send to embed
```java
DiscordWebhook webhook = DiscordWebhook("WebhookURL");

DiscordEmbedBuilder discordEmbedBuilder = DiscordEmbedBuilder();
discordEmbedBuilder.setTitle("Hello World!");
discordEmbedBuilder.setDescription("Hello Description!");

DiscordEmbed discordEmbed = discordEmbedBuilder.build();

webhook.addEmbed(discordEmbed);
webhook.execute(); // return DiscordResponse
```

### 3. Exception handling
```java
DiscordWebhook webhook = DiscordWebhook("WebhookURL");
webhook.setContent("Hello World!");
DiscordResponse discordResponse = webhook.execute(); // return DiscordResponse
if(discordResponse == 400){
    // Processing syntax when message sending via web hook fails.
}
```

## Example Kotlin
### 1. Send to content
```kotlin
val webhook = DiscordWebhook("WebhookURL")
webhook.setContent("Hello World!")
webhook.execute() // return DiscordResponse
```

### 2. Send to embed
```kotlin
val webhook = DiscordWebhook("WebhookURL")

val discordEmbedBuilder = DiscordEmbedBuilder()
discordEmbedBuilder.setTitle("Hello World!")
discordEmbedBuilder.setDescription("Hello Description!")

val discordEmbed = discordEmbedBuilder.build()

webhook.addEmbed(discordEmbed)
webhook.execute() // return DiscordResponse
```

### 3. Exception handling
```kotlin
val webhook = DiscordWebhook("WebhookURL")
webhook.setContent("Hello World!")

val discordResponse = webhook.execute() // return DiscordResponse
if(discordResponse == 400){
    // Processing syntax when message sending via web hook fails.
}

```