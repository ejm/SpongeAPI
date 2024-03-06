/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.event.message;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.adventure.ChatType;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Fired when sending a chat message.
 */
public interface PlayerChatEvent extends AudienceMessageEvent, Cancellable {

    /**
     * Returns the player sending the message.
     *
     * @return The player sending the message
     */
    Optional<ServerPlayer> player();

    /**
     * Returns the component to use as the sender.
     * In Vanilla this defaults to the players display name
     *
     * @return The sender component
     */
    Component sender();

    /**
     * Sets the component to use as the sender.
     *
     * @param sender The sender component
     */
    void setSender(Component sender);

    /**
     * Returns the component to use as the target.
     *
     * @return The target component
     */
    Optional<Component> target();

    /**
     * Sets the component to use as the target.
     *
     * @param target The target component
     */
    void setTarget(Component target);

    /**
     * Returns the chat type used.
     *
     * @return The chat type
     */
    RegistryReference<ChatType> chatType();

    /**
     * Sets the chat type.
     * To control the full message format use one of {@link org.spongepowered.api.adventure.ChatTypes#CUSTOM_CHAT}
     * or {@link org.spongepowered.api.adventure.ChatTypes#CUSTOM_MESSAGE}
     *
     * @param chatType the chat type to use.
     */
    void setChatType(RegistryReference<ChatType> chatType);

    /**
     * Returns true when {@link #originalMessage()} is signed and cannot be modified.
     *
     * @return True when signed
     */
    boolean isSigned();

}
